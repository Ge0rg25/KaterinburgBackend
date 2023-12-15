package ru.umom.katerinburg.mappers

import ru.umom.katerinburg.dto.CreateOrganizationRq
import ru.umom.katerinburg.dto.OrganizationDtoRs
import ru.umom.katerinburg.models.OrganizationEntity



fun CreateOrganizationRq.toEntity(): OrganizationEntity {
    return OrganizationEntity(
        title = title,
        description = description,
        address = address
    )
}


//fun UpdateOrganizationRq.toEntity(organizationRepository: OrganizationRepository): OrganizationEntity {
//    val organization: OrganizationEntity =
//        organizationRepository.findByIdOrNull(UUID.fromString(this.id)) ?: throw Exception("Organization not found")
//    organization.title = this.title
//    organization.description = this.description
//    organization.address = this.address
//    organization.photoId = this.photoId
//    return organization
//}



fun OrganizationEntity.toDto(): OrganizationDtoRs {
    return OrganizationDtoRs(
        id = id,
        title = title,
        description = description,
        photoId = photoId,
        address = address
    )
}


