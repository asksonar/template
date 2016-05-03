(ns web.components.header
  (:require [reagent.core :as r]))

(defn header []
  [:div "Header"
    [:a {:href "/#/login"} "Login"]
    [:a {:href "/#/logout"} "Logout"]
    [:a {:href "/#/posts"} "Posts"]])
