package io.androidedu.leagueoflegends.data.remote

import io.androidedu.leagueoflegends.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// Code with ❤️
//┌──────────────────────────┐
//│ Created by Gökhan ÖZTÜRK │
//│ ──────────────────────── │
//│ G.Ozturk@Papara.com      │            
//│ ──────────────────────── │
//│ 15.01.2022               │
//└──────────────────────────┘

abstract class RetrofitClient {
    companion object{

        private var INSTANCE: Retrofit? = null

        fun getInstance(): Retrofit {
            return INSTANCE ?: synchronized(this) {
                val instance = Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}