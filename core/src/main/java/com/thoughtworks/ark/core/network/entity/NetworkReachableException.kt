package com.thoughtworks.ark.core.network.entity

import java.io.IOException

class NetworkReachableException(msg: String? = "network is not reachable") : IOException(msg)