(ns web.pages.posts
  (:require [reagent.core :as r]))

(defn posts-page []
  [:div.main
    [:div.ui.cards
      [:div.card
        [:div.content
          [:div.header "Elliot Fu"]
          [:div.meta "Friend"]
          [:div.description
            "Elliot Fu is a film-maker from New York."]]]
      [:div.card
        [:div.content
          [:div.header "Veronika Ossi"]
          [:div.meta "Friend"]
          [:div.description
            "Veronika Ossi is a set designer living in New York who enjoys kittens, music, and partying."]]]
      [:div.card
        [:div.content
          [:div.header "Jenny Hess"]
          [:div.meta "Friend"]
          [:div.description
            "Jenny is a student studying Media Management at the New School."]]]]])
