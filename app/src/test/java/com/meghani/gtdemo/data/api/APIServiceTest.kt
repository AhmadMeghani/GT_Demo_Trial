package com.meghani.gtdemo.data.api

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIServiceTest {

    private lateinit var service: APIService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    private fun enqueueMockResponse(fileName: String) {
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)
    }

    @Test
    fun getData_sentRequest_receivedExpected() {
        runBlocking {
            enqueueMockResponse("apiresponse.json")
            val responseBody = service.getData()
            val request = server.takeRequest()
            assertThat(responseBody).isNotNull()
            assertThat(request.path).isEqualTo("/channels-socials.json")
        }
    }

    @Test
    fun getData_sentRequest_responseSuccessReceived() {
        runBlocking {
            enqueueMockResponse("apiresponse.json")
            val responseBody = service.getData()
            val responseStatus = responseBody.isSuccessful
            val header = responseBody.body()?.header

            assertThat(responseStatus).isTrue()
            assertThat(header!!.code).isEqualTo(1)
            assertThat(header.message).isEqualTo("Success")
        }
    }

    @Test
    fun getData_sentRequest_socialsReceived() {
        runBlocking {
            enqueueMockResponse("apiresponse.json")
            val responseBody = service.getData()
            val body = responseBody.body()?.body

            assertThat(body!!.socials.size).isGreaterThan(0)

        }
    }

    @Test
    fun getData_sentRequest_channelsReceived() {
        runBlocking {
            enqueueMockResponse("apiresponse.json")
            val responseBody = service.getData()
            val body = responseBody.body()?.body

            assertThat(body!!.channels.size).isGreaterThan(0)

        }
    }
}