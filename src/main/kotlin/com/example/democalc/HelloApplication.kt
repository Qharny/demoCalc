package com.example.democalc

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class HelloApplication : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("hello-view.fxml"))
        val scene = Scene(fxmlLoader.load(), 349.0, 580.0)
        stage.title = "DemoCalc!"
        stage.scene = scene
        stage.show()
    }
}

fun main() {
    Application.launch(HelloApplication::class.java)
}