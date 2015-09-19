(ns react-with-modular-cljs.core
  (:require [module$react$react :as React]
            [devtools.core :as devtools]
            [reagent.core :as reagent]))

(defn increment-button [counter text]
  (println "increment-button re-rendered!")
  [:button {:on-click (fn [e]
                        (swap! counter inc)
                        (.preventDefault e))}
           text])

(defn test-component []
  (let [counter (reagent/atom 0)]
    (println "test-component re-mounted!")
    (fn []
      (println "test-component re-rendered!")
      [:div {:style {:color "red"}}
        [:p "Test: " @counter]
        [increment-button counter "Click me!"]])))

(enable-console-print!)

(defn install-devtools []
  (devtools/install!))

(defn mount-root! []
  (reagent/render [test-component] (.-body js/document)))

(defn app-init! []
  (install-devtools)
  (.log js/console "testing devtools" {:some ["clojurescript" #{1 2 3 ["devtools" "test"]}]})
  (println "starting app")
  (mount-root!))

(defn app-reload! []
  (println "reloading app")
  (mount-root!))
