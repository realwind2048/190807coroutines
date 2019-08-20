package com.buzzvil.buzzscreen.a190807coroutines.old

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitTest {
    fun getList() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(GitHubService::class.java)

        val repos = service.listRepos("buzzvil")
        repos.enqueue(object : Callback<List<Repo>> {
            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
                Log.d("TRACK_DEBUG", "onFailure")
            }

            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
                Log.d("TRACK_DEBUG", "onSuccess")
                response.body()?.forEach {
                    Log.d("TRACK_DEBUG", "name = ${it.name}")
                }
            }
        })

        val contributors = service.contributors("square", "retrofit")
        contributors.enqueue(object : Callback<List<Contributor>> {
            override fun onFailure(call: Call<List<Contributor>>, t: Throwable) {
                Log.d("TRACK_DEBUG", "onFailure")
            }

            override fun onResponse(call: Call<List<Contributor>>, response: Response<List<Contributor>>) {
                Log.d("TRACK_DEBUG", "onSuccess")
                response.body()?.forEach {
                    Log.d("TRACK_DEBUG", "login = ${it.login}, contributioin = ${it.contributions}")
                }
            }
        })
    }
}

interface GitHubService {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Call<List<Repo>>

    @GET("/repos/{owner}/{repo}/contributors")
    fun contributors(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Call<List<Contributor>>
}

class Contributor(val login: String, val contributions: Int)

class Repo(val name: String)