package com.chariot.landing.models


enum class SectionAnimation(
    val id: String,
    val title: String,
    val path: String
) {

    WhatYouNeed(
        id = "whatYouNeedId",
        title = "",
        path = "#whatYouNeedId"
    ),

    WhatSpecialIconTop(
        id = " whatSpecialImageTopId",
        title = "",
        path = "#whatSpecialImageTopId"
    ),

    WhatSpecialIconBottom(
        id = "whatSpecialImageBottomId",
        title = "",
        path = "#whatSpecialImageBottomId"
    )
}



enum class Section(
    val id: String,
    val title: String,
    val path: String
) {
    Home(
        id = "homeId",
        title = "Home",
        path = "#homeId"
    ),
    Vendors(
        id = "vendorsId",
        title = "Vendors",
        path = "#vendorsId"
    ),
    Riders(
        id = "ridersId",
        title = "Riders",
        path = "#ridersId"
    ),

    Contact(
        id = "contactId",
        title = "Contact us",
        path = "#contactId"
    ),

    Footer(
    id = "footerId",
    title = "Footer",
    path = "#footerId"
    )
}