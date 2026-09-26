package com.google.android.accessibility.selecttospeak

import com.jev.probe.capture.ChatCaptureService

/**
 * The live capture service, registered under this system-style class name so
 * apps that obfuscate their node tree against plainly-named services still
 * expose it (verified in P1: a plainly-named service is blocked to a single
 * empty node, this class reads the full chat). All logic lives in
 * [ChatCaptureService]; only the class name differs.
 *
 * Do not rename this class or its Manifest registration — the disguise is what
 * gets past those apps' node obfuscation.
 */
class SelectToSpeakService : ChatCaptureService()
