package no.nav.pgi.domain

data class PensjonsgivendeInntekt(
    val norskPersonidentifikator: String? = null,
    val inntektsaar: Long = 0,
    val pensjonsgivendeInntekt: List<PensjonsgivendeInntektPerOrdning>? = null,
    val metaData: PensjonsgivendeInntektMetadata? = null,
)