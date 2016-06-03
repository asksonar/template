(ns web.routes
  (:require [reagent.core :as r]
            [secretary.core :as secretary :include-macros true]
            [goog.events :as events]
            [goog.history.EventType :as EventType]
            [web.controls :as controls]
            [web.session :as session]
            [web.pages.home :refer [home-page]]
            [web.pages.login :refer [login-page]]
            [web.pages.posts :refer [posts-page]])
  (:import goog.History))

(defn redirect! [path]
  (aset js/window "location" path))

(defn redirect-to-login-if-no-user! []
  (if (nil? (session/user))
    (redirect! "/#/login")))

(secretary/set-config! :prefix "#")

(secretary/defroute "/" []
  (controls/set-page! home-page))

(secretary/defroute "/login" []
  (controls/set-page! login-page))

(secretary/defroute "/logout" []
  (controls/set-user! nil)
  (controls/set-page! home-page))

(secretary/defroute "/posts" []
  (controls/set-page! posts-page))

(secretary/defroute "/*" []
  (redirect! "/404"))

(doto (History.)
  (events/listen
   EventType/NAVIGATE
   (fn [event]
     (secretary/dispatch! (.-token event))))
  (.setEnabled true))
