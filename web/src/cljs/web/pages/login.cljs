(ns web.pages.login
  (:require [reagent.core :as r]))

(defn login-page []
  [:div.ui.middle.aligned.center.aligned.grid
    [:div.column
      [:h2.ui.teal.image.header
        [:div.content "Login to your account"]]
      [:form.ui.large.form.error
        [:div.ui.stacked.segment
          [:div.field
            [:div.ui.left.icon.input
              [:i.user.icon]
              [:input {:type "text"
                       :name "email"
                       :placeholder "E-mail address"}]]]
          [:div.field
            [:div.ui.left.icon.input
              [:i.lock.icon]
              [:input {:type "password"
                       :name "password"
                       :placeholder "Password"}]]]
          [:div.ui.fluid.large.teal.submit.button "Login"]]
        [:div.ui.error.message]]
      [:div.ui.message
        [:a {:href "/#/forgot-password"} "Forgot your password?"]]]])
