package com.livemagazine.livemagazinekmp.depenencies

interface MyRepository {
    fun helloWorld():String
}

class MyRepositoryImpl(
    private val dbClient: DbClient
): MyRepository
{
    override fun helloWorld() = "Hello diaa with kmp"

}

class MyAgainRepositoryImpl(
    private val dbClient: DbClient
): MyRepository
{
    override fun helloWorld() = "Hello diaa with kmp again repository"

}

