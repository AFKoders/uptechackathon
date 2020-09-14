package com.afkoders.uptechackathon.data.exception

import java.io.IOException

class NoConnectivityException : IOException() {
    override val message: String
        get() = "No connectivity exception"
}