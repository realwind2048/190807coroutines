package com.buzzvil.buzzscreen.a190807coroutines.uc05retrofit.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

class RetrofitCoroutinesTest {
    private var service: GitHubService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(GitHubService::class.java)
    }

    suspend fun getList1(): List<Repo> {
        return withContext(Dispatchers.IO) {
            service.listRepos("buzzvil")
        }
    }

    suspend fun getList2(): List<Repo> = service.listRepos("buzzvil")
}

interface GitHubService {
    @GET("users/{user}/repos")
    suspend fun listRepos(@Path("user") user: String): List<Repo>
}

class Repo(val name: String)