(ns web.components.header
  (:require [reagent.core :as r]))

(defn header []
  [:div.ui.fixed.inverted.menu
    [:div.ui.container
      [:a.header.item {:href "/#"} "Template"]
      [:a.item {:href "/#/posts"} "Posts"]
      [:div.ui.simple.dropdown.item "Account"
        [:i.dropdown.icon]
        [:div.menu
          [:a.item {:href "/#/login"} "Login"]
          [:a.item {:href "/#/logout"} "Logout"]]]]])
