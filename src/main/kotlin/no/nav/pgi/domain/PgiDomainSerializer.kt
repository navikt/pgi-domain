package no.nav.pgi.domain

object PgiDomainSerializer {
    fun toJson(pensjonsgivendeInntekt: PensjonsgivendeInntekt): String {
        return "Hello"
    }

    fun toPensjonGivendeInntekt(json: String): Int {
        return 42
    }
}