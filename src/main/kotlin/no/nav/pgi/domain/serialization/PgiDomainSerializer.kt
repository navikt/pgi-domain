package no.nav.pgi.domain.serialization

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import no.nav.pgi.domain.*
import kotlin.reflect.KClass

class PgiDomainSerializer {

    val objectMapper = ObjectMapper().registerModule(KotlinModule.Builder().build())

    fun toJson(pgiDomainObject: Any): String {
        return when (pgiDomainObject) {
            is Hendelse,
            is HendelseKey,
            is HendelseMetadata,
            is PensjonsgivendeInntekt,
            is PensjonsgivendeInntektMetadata,
            is PensjonsgivendeInntektPerOrdning,
            is Skatteordning,
                -> objectMapper.writeValueAsString(pgiDomainObject)

            else -> throw PgiDomainSerializationException("Unsupported class ${pgiDomainObject.javaClass.name}")
        }
    }

    fun <T : Any> fromJson(pgiDomainObjectClass: KClass<T>, json: String): T {
        return when (pgiDomainObjectClass) {
            Hendelse::class,
            HendelseKey::class,
            HendelseMetadata::class,
            PensjonsgivendeInntekt::class,
            PensjonsgivendeInntektMetadata::class,
            PensjonsgivendeInntektPerOrdning::class,
            Skatteordning::class,
                ->
                objectMapper.readValue(json, pgiDomainObjectClass.java)!!

            else -> throw PgiDomainSerializationException("Unsupported class ${pgiDomainObjectClass.simpleName}")
        }
    }

    class PgiDomainSerializationException(msg: String) : RuntimeException(msg)
}
