(ns web.app
  (:require [reagent.core :as r]
            [cljsjs.semantic-ui]
            [dirac.runtime :as dirac]
            [dirac.runtime.prefs :as dirac-prefs]
            [devtools.core :as devtools]
            [secretary.core :as secretary :include-macros true]
            [web.components.header :refer [header]]
            [web.components.footer :refer [footer]]
            [web.session :as session]
            [web.controls :as controls]
            [web.pages.home :refer [home-page]]
            [web.routes :as routes]))

(defn app []
  [:div
    [header]
    [:div.pusher
      [(session/page)]
      [footer]]])

(defn init []
  (dirac/install!)
  (devtools/install! [:custom-formatters :sanity-hints])
  (dirac-prefs/set-pref! :agent-host "my_app.docker")
  ; (routes/redirect-to-login-if-no-user!)
  (r/render-component [app]
    (.getElementById js/document "container")))
