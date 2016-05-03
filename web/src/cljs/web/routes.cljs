(ns web.routes
  (:require [reagent.core :as r]
            [secretary.core :as secretary :include-macros true]
            [goog.events :as events]
            [goog.history.EventType :as EventType]
            [web.controls :as controls]
            [web.pages.home :refer [home-page]]
            [web.pages.login :refer [login-page]]
            [web.pages.posts :refer [posts-page]])
  (:import goog.History))

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

(doto (History.)
  (events/listen
   EventType/NAVIGATE
   (fn [event]
     (secretary/dispatch! (.-token event))))
  (.setEnabled true))
