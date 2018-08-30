package io.viewpoint.dooray.hook.requests

import io.viewpoint.dooray.hook.models.Hook

data class HookRequest(var hookUrl: String, var hook: Hook)