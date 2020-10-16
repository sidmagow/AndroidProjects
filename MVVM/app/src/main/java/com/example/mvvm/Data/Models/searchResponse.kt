package com.example.mvvm.Data.Models

data class SearchResponse(
	val totalCount: Int? = null,
	val incompleteResults: Boolean? = null,
	val items: List<User?>? = null
)


