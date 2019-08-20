package com.buzzvil.buzzscreen.a190807coroutines.uc05retrofit.normal

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

class RetrofitNormalTest(view: GetListResult) {
    private var service: GitHubService
    private var view: GetListResult

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(GitHubService::class.java)
        this.view = view
    }

    fun getList() {
        val repos = service.listRepos("buzzvil")
        repos.enqueue(object : Callback<List<Repo>> {
            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
                Log.d("TRACK_DEBUG", "onFailure")
                view.onFailure()
            }

            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
                Log.d("TRACK_DEBUG", "onSuccess")
                response.body()?.forEach {
                    Log.d("TRACK_DEBUG", "name = ${it.name}")
                }
                view.onSuccess(response.body())
            }
        })
    }
}

interface GitHubService {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Call<List<Repo>>
}

class Repo(val name: String)

interface GetListResult {
    fun onFailure()
    fun onSuccess(repos: List<Repo>?)
}