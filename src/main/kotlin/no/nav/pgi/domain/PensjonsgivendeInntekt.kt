package no.nav.pgi.domain

data class PensjonsgivendeInntekt(
    val norskPersonidentifikator: String,
    val inntektsaar: Long,
    val pensjonsgivendeInntekt: List<PensjonsgivendeInntektPerOrdning>,
    val metaData: PensjonsgivendeInntektMetadata,
)