package ru.umom.katerinburg.services

import lombok.AccessLevel
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class OrganizationService {
    var organizationRepository: OrganizationRepository? = null


    fun create(dto: OrganizationDto.Request.Create): ResponseEntity<*> {
        val organizationEntity: OrganizationEntity = OrganizationEntity.builder()
            .title(dto.title())
            .description(dto.description())
            .address(dto.address())
            .photoId(dto.photoId())
            .build()

        organizationRepository.save(organizationEntity)
        return ResponseEntity.ok().build<Any>()
    }

    fun update(dto: OrganizationDto.Request.Update): ResponseEntity<*> {
        val organizationEntity: OrganizationEntity = organizationRepository.findById(dto.id()).orElseThrow()

        organizationEntity.setTitle(dto.title())
        organizationEntity.setDescription(dto.description())
        organizationEntity.setAddress(dto.address())
        organizationEntity.setPhotoId(dto.photoId())

        organizationRepository.save(organizationEntity)
        return ResponseEntity.ok().build<Any>()
    }


    fun delete(dto: OrganizationDto.Request.Delete): ResponseEntity<*> {
        val organizationEntity: OrganizationEntity = organizationRepository.findById(dto.id()).orElseThrow()
        organizationRepository.delete(organizationEntity)

        return ResponseEntity.ok().build<Any>()
    }


    val all: ResponseEntity<*>
        get() {
            val organizations: List<OrganizationEntity> = organizationRepository.findAll()
            val responses: MutableList<OrganizationDto.Response.BaseResponse> =
                ArrayList<OrganizationDto.Response.BaseResponse>()

            for (organizationEntity in organizations) {
                responses.add(
                    entityToBaseResponse(organizationEntity)
                )
            }

            return ResponseEntity.ok<List<OrganizationDto.Response.BaseResponse>>(responses)
        }


    private fun entityToBaseResponse(organization: OrganizationEntity): OrganizationDto.Response.BaseResponse {
        return BaseResponse(
            organization.getId(),
            organization.getTitle(),
            organization.getDescription(),
            organization.getAddress(),
            organization.getPhotoId()
        )
    }
}
