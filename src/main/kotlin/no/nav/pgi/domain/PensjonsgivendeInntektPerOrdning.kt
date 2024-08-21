package no.nav.pgi.domain

data class PensjonsgivendeInntektPerOrdning(
    val skatteordning: Skatteordning? = null,
    val datoForFastsetting: String? = null,
    val pensjonsgivendeInntektAvLoennsinntekt: Long? = null,
    val pensjonsgivendeInntektAvLoennsinntektBarePensjonsdel: Long? = null,
    val pensjonsgivendeInntektAvNaeringsinntekt: Long? = null,
    val pensjonsgivendeInntektAvNaeringsinntektFraFiskeFangstEllerFamiliebarnehage: Long? = null
)