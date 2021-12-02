package com.gmm.twittmap.model

data class Twitt(val data:ArrayList<Data>)

data class Data(val id:String, val text:String, val geo:Geo)

data class Geo(val coordinates: Coordinates)

data class Coordinates(val coordinates: Array<Double>)