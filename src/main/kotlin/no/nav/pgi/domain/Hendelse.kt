package no.nav.pgi.domain

data class Hendelse(
    val sekvensnummer: Long = 0,
    val identifikator: String? = null,
    val gjelderPeriode: String? = null,
    val metaData: HendelseMetadata? = null
)
