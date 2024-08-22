package no.nav.pgi.domain

data class PensjonsgivendeInntektPerOrdning(
    val skatteordning: Skatteordning,
    val datoForFastsetting: String,
    val pensjonsgivendeInntektAvLoennsinntekt: Long?,
    val pensjonsgivendeInntektAvLoennsinntektBarePensjonsdel: Long?,
    val pensjonsgivendeInntektAvNaeringsinntekt: Long?,
    val pensjonsgivendeInntektAvNaeringsinntektFraFiskeFangstEllerFamiliebarnehage: Long?,
)