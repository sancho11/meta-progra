SUMMARY = "Initial boot script"
DESCRIPTION = "Script to do any first boot init, started as a systemd service which removes itself once finished"
LICENSE = "CLOSED"
PR = "r3"

SRC_URI =  " \
    file://initscript.sh \
    file://faces.sh \
"

do_compile () {
}

do_install () {
    install -d ${D}/${sbindir}
    install -m 0755 ${WORKDIR}/initscript.sh ${D}/${sbindir}

    install -d ${D}/${sbindir}
    install -m 0755 ${WORKDIR}/faces.sh ${D}/${sbindir}
}

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "initscript.service"

inherit allarch systemd


