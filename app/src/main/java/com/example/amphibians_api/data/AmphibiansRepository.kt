package com.example.amphibians_api.data

import com.example.amphibians_api.model.Amphibian
import com.example.amphibians_api.network.AmphibiansApiService

interface AmphibiansRepository {
    suspend fun getAmphibians(): List<Amphibian>
}

class DefaultAmphibiansRepository(
    private val amphibiansApiService: AmphibiansApiService
) : AmphibiansRepository {
    //    override suspend fun getAmphibians(): List<Amphibian> = amphibiansApiService.getAmphibians()
    override suspend fun getAmphibians(): List<Amphibian> {
        return amphibiansApiService.getAmphibians()
    }

}