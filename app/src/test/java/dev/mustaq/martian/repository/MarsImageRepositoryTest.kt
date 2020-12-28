package dev.mustaq.martian.repository

import dev.mustaq.martian.data.MarsTestData
import dev.mustaq.martian.data.MockServiceApi
import dev.mustaq.martian.data.MockServiceApiForFailScenario
import dev.mustaq.martian.mapper.MarsImageDataMapper
import dev.mustaq.martian.model.MarsPhotoModel
import dev.mustaq.martian.responsehandler.CustomResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.junit.Assert.*
import retrofit2.Response


/**
 * Created by Mustaq Sameer on 28/12/20
 */

@OptIn(ExperimentalCoroutinesApi::class)
class MarsImageRepositoryTest {

    @Test
    fun getMarsImageDataFromServer_checkRemoteDataMatchesSuccessResponse() = runBlockingTest {
        val successResponse = Response.success(MarsPhotoModel(MarsTestData.getData()))
        val serviceApi by lazy { MockServiceApi() }
        val repository = MarsImageRepository(serviceApi)
        val response = repository.getMarsImageDataFromServer() as CustomResponse.Success
        val responseFromServer = serviceApi.getMarsImages()
        val expectedResponse = MarsImageDataMapper.map(responseFromServer)

        assertNotNull(responseFromServer)
        assertEquals(successResponse.code(), responseFromServer.code())
        assertEquals(response, expectedResponse)
    }

    @Test
    fun getMarsImageDataFromServer_checkRemoteFailureMatchesFailureResponse() = runBlockingTest {
        val serviceApi by lazy { MockServiceApiForFailScenario() }
        val repository = MarsImageRepository(serviceApi)
        val response = repository.getMarsImageDataFromServer() as CustomResponse.Failure
        val responseFromServer = serviceApi.getMarsImages()
        val expectedResponse = MarsImageDataMapper.map(responseFromServer)
        assertNotNull(responseFromServer)
        assertEquals(responseFromServer.code(), 400)
        assertEquals(response, expectedResponse)
    }


}