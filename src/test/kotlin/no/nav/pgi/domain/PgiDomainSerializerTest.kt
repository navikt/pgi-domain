package no.nav.pgi.domain

import org.junit.jupiter.api.Test

class PgiDomainSerializerTest {

    private const val PID = "12345678901"

    @Test
    fun `serialiser og deserialiser`() {
        val pensjonsgivendeInntekt = PensjonsgivendeInntekt(
            norskPersonidentifikator = PID,
            inntektsaar = 2020,
            pensjonsgivendeInntekt = listOf(
                PensjonsgivendeInntektPerOrdning(
                    skatteordning = Skatteordning.SVALBARD,
                    datoForFastsetting = "2020-02-02",
                    pensjonsgivendeInntektAvLoennsinntekt = 1,
                    pensjonsgivendeInntektAvLoennsinntektBarePensjonsdel = 2,
                    pensjonsgivendeInntektAvNaeringsinntekt = 3,
                    pensjonsgivendeInntektAvNaeringsinntektFraFiskeFangstEllerFamiliebarnehage = 4,
                )
            )
        )
        val json = PgiDomainSerializer.toJson(pensjonsgivendeInntekt)
        val objekt = PgiDomainSerializer.toPensjonGivendeInntekt(json)

    }


}
}