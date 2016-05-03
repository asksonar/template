(ns web.app
  (:require [reagent.core :as r]
            [cljsjs.semantic-ui]
            [dirac.runtime :as dirac]
            [devtools.core :as devtools]
            [secretary.core :as secretary :include-macros true]
            [web.components.header :refer [header]]
            [web.components.footer :refer [footer]]
            [web.session :as session]
            [web.controls :as controls]
            [web.pages.home :refer [home-page]]
            [web.routes]))

(defn app []
  [:div
    [header]
    [(session/page)]
    [footer]])

(defn init []
  (dirac/install!)
  (devtools/install! [:custom-formatters :sanity-hints])
  (r/render-component [app]
    (.getElementById js/document "container")))
