(defproject react-with-modular-cljs "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :source-paths #{"src"}
  :exclusions [org.clojure/clojurescript]
  :dependencies [[org.clojars.jaen/clojurescript "0.0-SNAPSHOT"]
                 [org.clojars.jaen/reagent "0.5.2-SNAPSHOT"]
                 [org.cojars.jaen/boot-cljs "0.0-SNAPSHOT"]
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
