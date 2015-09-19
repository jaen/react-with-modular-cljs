(set-env!
  :source-paths #{"src"}
  :resource-paths #{"resources"}
  :exclusions '[org.clojure/clojurescript com.google.javascript/closure-compiler]
  :dependencies '[[org.clojars.jaen/clojurescript "0.0-SNAPSHOT"]
                  [org.clojars.jaen/reagent "0.5.2-SNAPSHOT"]
                  [org.clojars.jaen/boot-cljs "0.0-SNAPSHOT"]
                  [adzerk/boot-cljs-repl "0.1.10-SNAPSHOT" :scope "test"]

                  [binaryage/devtools "0.3.0"]

                  [weasel "0.7.0"]
                  [com.cemerick/austin "0.1.7-SNAPSHOT"]
                  [com.cemerick/piggieback "0.2.1"]
                  [org.clojure/clojure       "1.7.0"]
                  [org.clojure/tools.nrepl "0.2.10" :exclusions [org.clojure/clojure]]
                  [adzerk/boot-reload "0.3.1" :scope "test"]
                  [pandeiro/boot-http "0.6.3-SNAPSHOT" :scope "test"]
                  [jeluard/boot-notify "0.2.0" :scope "test"]])

(require
  '[adzerk.boot-cljs :as cljsb :refer [cljs]]
  '[adzerk.boot-reload :as rb]
  '[jeluard.boot-notify :refer [notify]]
  '[pandeiro.boot-http :refer :all]
  '[adzerk.boot-cljs-repl :as cljs-repl])


(deftask dev
         "Run a restartable system in the Repl"
         []
         ;(set-env! :source-paths #(conj % "dev"))
         (comp
           (serve :dir "target/public":port 8080)
           (watch :verbose true)
           (rb/reload :on-jsload 'react-with-modular-cljs.core/app-reload!)
           (cljs-repl/cljs-repl)
           (cljsb/cljs :source-map true
                       :optimizations :none
                       :compiler-options {:libs [{:path "node_modules/react"
                                                  :name "react"
                                                  :files ["react.js" "addons.js" "lib/"]
                                                  ; :main "react.js"
                                                  :module-type :commonjs}]
                                          :main         "react-with-modular-cljs.core"
                                          ;:asset-path   "/assets/javascripts/cljs-out"
                                          ;:output-dir   "out"
                                          })
           (notify)))

(defn cljs-repl! []
  (cljs-repl/start-repl))
