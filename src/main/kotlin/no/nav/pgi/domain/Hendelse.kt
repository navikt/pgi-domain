package no.nav.pgi.domain

data class Hendelse(
    val sekvensnummer: Long,
    val identifikator: String,
    val gjelderPeriode: String,
    val metaData: HendelseMetadata,
)
