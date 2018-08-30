package io.viewpoint.dooray.hook.models

data class Hook(var botName: String, var botIconImage: String?, var text: String, var attachments: List<Attachment>?)
data class Attachment(var title: String, var titleLink: String?, var text: String, var color: String?, var image: String?)