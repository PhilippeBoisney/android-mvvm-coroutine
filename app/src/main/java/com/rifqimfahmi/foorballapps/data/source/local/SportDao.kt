package com.rifqimfahmi.foorballapps.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.rifqimfahmi.foorballapps.features.matches.MatchesListFragment
import com.rifqimfahmi.foorballapps.vo.Match

/*
 * Created by Rifqi Mulya Fahmi on 21/11/18.
 */

@Dao
interface SportDao {

    @Query("SELECT * FROM matches WHERE idLeague = :idLeague AND matchType = '${MatchesListFragment.TYPE_NEXT_MATCH}'")
    fun getNextMatches(idLeague: String?): LiveData<List<Match>>

    @Query("SELECT * FROM matches WHERE idLeague = :idLeague AND matchType = '${MatchesListFragment.TYPE_PREV_MATCH}'")
    fun getPrevMatches(idLeague: String?): LiveData<List<Match>>

    @Query("DELETE FROM matches WHERE matchType = '${MatchesListFragment.TYPE_NEXT_MATCH}' AND idLeague = :idLeague")
    fun deleteNextMatches(idLeague: String?)

    @Query("DELETE FROM matches WHERE matchType = '${MatchesListFragment.TYPE_PREV_MATCH}' AND idLeague = :idLeague")
    fun deletePrevMatches(idLeague: String?)

    @Insert
    fun saveMatches(matches: List<Match?>?)


}