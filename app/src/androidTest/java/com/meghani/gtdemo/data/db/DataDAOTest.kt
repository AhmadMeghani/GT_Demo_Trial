package com.meghani.gtdemo.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.meghani.gtdemo.data.model.Channel
import com.meghani.gtdemo.data.model.Social
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DataDAOTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dao: DataDAO
    private lateinit var db: AppDatabase

    @Before
    fun setUp() {
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).build()

        dao = db.getDao()
    }

    @After
    fun tearDown() {
        db.close()
    }

    @Test
    fun socialsTest_insertAndGet() = runBlocking{
        val socials = listOf(
            Social(1, "iconUrl1", "name1", "package1", "url1"),
            Social(2, "iconUrl2", "name2", "package2", "url2"),
            Social(3, "iconUrl3", "name3", "package3", "url3"),
            Social(4, "iconUrl4", "name4", "package4", "url4")
        )

        dao.insertSocials(socials)

        dao.getSocials().collect{
            val allSocials = it
            Truth.assertThat(allSocials).isEqualTo(socials)
        }

    }

    @Test
    fun channelsTest_insertAndGet() = runBlocking{
        val channels = listOf(
            Channel(1, "iconUrl1", "name1", "package1", "url1"),
            Channel(2, "iconUrl2", "name2", "package2", "url2"),
            Channel(3, "iconUrl3", "name3", "package3", "url3"),
            Channel(4, "iconUrl4", "name4", "package4", "url4")
        )

        dao.insertChannels(channels)

        dao.getChannels().collect{
            val allChannel = it
            Truth.assertThat(allChannel).isEqualTo(channels)
        }

    }
}