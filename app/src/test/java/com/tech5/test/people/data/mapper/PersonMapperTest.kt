package com.tech5.test.people.data.mapper

import com.tech5.test.people.data.remote.dto.PersonDTO
import org.junit.Assert.assertEquals
import org.junit.Test

class PersonMapperTest {

    @Test
    fun `toPerson maps PersonDTO to Person correctly`() {
        // Given
        val dto = PersonDTO(
            id = 1,
            name = "John Doe",
            known_for_department = "Acting",
            popularity = 8.5,
            profile_path = "/path.jpg",
            known_for = emptyList()
        )

        // When
        val person = dto.toPerson()

        // Then
        assertEquals(dto.id, person.id)
        assertEquals(dto.name, person.name)
        assertEquals(dto.known_for_department, person.known_for_department)
        assertEquals(dto.popularity, person.popularity)
        assertEquals("https://image.tmdb.org/t/p/w500/path.jpg", person.profilePath)
        assertEquals(dto.known_for, person.known_for)
    }

    @Test
    fun `toPerson handles null values correctly`() {
        // Given
        val dto = PersonDTO(
            id = null,
            name = null,
            known_for_department = null,
            popularity = null,
            profile_path = null,
            known_for = null
        )

        // When
        val person = dto.toPerson()

        // Then
        assertEquals(0, person.id)
        assertEquals("", person.name)
        assertEquals("", person.known_for_department)
        assertEquals(null, person.popularity)
        assertEquals(null, person.profilePath)
        assertEquals(null, person.known_for)
    }
}
