package com.chariot.landing.api

import kotlinx.browser.window
import kotlinx.coroutines.await
import org.w3c.fetch.RequestInit
import org.w3c.fetch.Response
import kotlin.js.json

private const val ENDPOINT_BASE_URL = "https://chariotconnectbackend.onrender.com/api/v1"

sealed class NewsletterResult {
    data object Success : NewsletterResult()
    data class Error(val message: String) : NewsletterResult()
}

suspend fun subscribeToNewsletter(email: String): NewsletterResult {
  //  println("subscribeToNewsletter called with email='$email'")
    return try {
        val response: Response = window.fetch(
            "$ENDPOINT_BASE_URL/newsletter",
            RequestInit(
                method = "POST",
                headers = json("Content-Type" to "application/json"),
                body = JSON.stringify(json("email" to email))
            )
        ).await()

        //println("Newsletter response status: ${response.status}")

        when (response.status.toInt()) {
            201 -> NewsletterResult.Success
            400 -> NewsletterResult.Error("Email is required.")
            409 -> NewsletterResult.Error("You're already subscribed.")
            500 -> NewsletterResult.Error("Something went wrong. Try again later.")
            else -> NewsletterResult.Error("Unexpected error (${response.status}).")
        }
    } catch (e: Throwable) {
       // println("Newsletter request threw exception: ${e.message}")
        NewsletterResult.Error("Network error. Check your connection.")
    }
}


