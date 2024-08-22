package no.nav.pgi.domain

import no.nav.pgi.domain.serialization.PgiDomainSerializer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PgiDomainPgiDomainSerializerTest {

    private val personId = "12345678901"


    @Test
    fun `serialiser og deserialiser HendelseKey`() {
        val key = HendelseKey(identifikator = "12345678901", gjelderPeriode = "Q1")
        val json = PgiDomainSerializer().toJson(key)
        println(json)
        val value = PgiDomainSerializer().fromJson(pgiDomainObjectClass = HendelseKey::class, json)
        assertThat(value).isEqualTo(key)
    }

    @Test
    fun `serialiser og deserialiser PensjonsgivendeInntekt`() {
        val pensjonsgivendeInntekt = PensjonsgivendeInntekt(
            norskPersonidentifikator = personId,
            inntektsaar = 2020,
            pensjonsgivendeInntekt = listOf(
                PensjonsgivendeInntektPerOrdning(
                    skatteordning = Skatteordning.SVALBARD,
                    datoForFastsetting = "2020-02-02",
                    pensjonsgivendeInntektAvLoennsinntekt = 1,
                    pensjonsgivendeInntektAvLoennsinntektBarePensjonsdel = 2,
                    pensjonsgivendeInntektAvNaeringsinntekt = 3,
                    pensjonsgivendeInntektAvNaeringsinntektFraFiskeFangstEllerFamiliebarnehage = 4,
                ),
            ),
            metaData = PensjonsgivendeInntektMetadata(retries = 0, sekvensnummer = 42)
        )
        val json = PgiDomainSerializer().toJson(pensjonsgivendeInntekt)
        println(json)
        val value = PgiDomainSerializer().fromJson(PensjonsgivendeInntekt::class, json)
        assertThat(value).isEqualTo(pensjonsgivendeInntekt)
    }
}