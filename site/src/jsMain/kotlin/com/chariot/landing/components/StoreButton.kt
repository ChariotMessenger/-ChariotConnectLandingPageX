package com.chariot.landing.components

import androidx.compose.runtime.Composable
import com.chariot.landing.styles.VisitStoreStyle
import com.chariot.landing.util.ConstantsObject
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignContent
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.onContextMenu
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.userSelect
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.AlignContent
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text


@Composable
fun StoreButton(
    modifier: Modifier = Modifier,
    breakpoint: Breakpoint,
    buttonText: String,
    buttonIcon: String,
    storeLink: String,

    ){

//    Box(modifier = modifier
//        .fillMaxWidth()
//    ) {

    Link(
        modifier = modifier
            .then(      if (breakpoint <= Breakpoint.SM) {
                Modifier.fillMaxWidth(if (breakpoint <= Breakpoint.ZERO) 100.percent else 90.percent)
            } else {
                Modifier
            }
            )
            .textDecorationLine(TextDecorationLine.None)
            // Disable right-click / long-press
            .onContextMenu { event ->
                event.preventDefault()
                event.stopPropagation()
            },
        path = storeLink,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    )
    {


        Button(
            attrs = VisitStoreStyle.toModifier()
                .border(width = 0.px)
                .borderRadius(r = 8.px)
                .color(Color.white)
                .fontFamily(ConstantsObject.FONT_FAMILY, ConstantsObject.FALL_BACK_FONT)
                .fontWeight(FontWeight.SemiBold)
                .fontSize(
                    if (breakpoint <= Breakpoint.ZERO) {
                        14.px
                    } else {
                        if (breakpoint <= Breakpoint.SM) {
                            14.px
                        } else {
                            if (breakpoint <= Breakpoint.MD) {
                                14.px
                            } else {
                                if (breakpoint <= Breakpoint.LG) {
                                    16.px
                                } else {
                                    18.px
                                }
                            }
                        }
                    }

                )
                .fontWeight(400)
                .alignContent(AlignContent.Center)
                .cursor(Cursor.Pointer)
                .userSelect(UserSelect.None)
                .padding(
                    leftRight = if (breakpoint <= Breakpoint.ZERO) {
                        40.px
                    } else {
                        if (breakpoint <= Breakpoint.SM) {
                            40.px
                        } else {
                            if (breakpoint <= Breakpoint.MD) {
                                26.px
                            } else 30.px
                        }
                    },
                    topBottom = if (breakpoint <= Breakpoint.ZERO) {
                        12.px
                    } else {
                        if (breakpoint <= Breakpoint.SM) {
                            14.px
                        } else {
                            if (breakpoint <= Breakpoint.MD) {
                                16.px
                            } else 18.px
                        }
                    }
                )
                // Disable right-click / long-press
                .onContextMenu { event ->
                    event.preventDefault()
                    event.stopPropagation()
                }
                .toAttrs()
        )
        {

            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically,
                //horizontalArrangement = Arrangement.spacedBy(8.px) ,
                horizontalArrangement = Arrangement.Center
            ) {

                Image(
                    modifier = Modifier
                        .size(
                            size = if (breakpoint <= Breakpoint.ZERO) {
                                20.px
                            } else {
                                if (breakpoint <= Breakpoint.SM) {
                                    20.px
                                } else {
                                    if (breakpoint <= Breakpoint.MD) {
                                        20.px
                                    } else {

                                        22.px
                                    }
                                }
                            }
                        )
                        // Disable right-click / long-press
                        .onContextMenu { event ->
                            event.preventDefault()
                            event.stopPropagation()
                        },
                    src = buttonIcon,
                    description = "store icon",
                )

                Div(attrs = {
                    style {
                        width(8.px)
                    }
                }
                )

                Text(value = buttonText)


            }

        }

    }


    //}



}



