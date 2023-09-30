package com.wektorzabrze.coogle.user.service


import com.wektorzabrze.coogle.user.entity.FinalsScore
import org.springframework.stereotype.Service

@Service
class UserService {

    private var finalsScores: Collection<FinalsScore> = emptyList()

    fun updateFinals(finalsScores: List<FinalsScore>): List<FinalsScore> {
        this.finalsScores = finalsScores

        return finalsScores
    }

    fun getUserFinals(): Map<String, FinalsScore> = this.finalsScores.associateBy { it.subject }
}