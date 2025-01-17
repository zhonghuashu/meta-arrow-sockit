SUMMARY = "Arrow SoCKit XFCE service"
DESCRIPTION = "Start xfce after FPGA load."
AUTHOR = "Dan Negvesky <dnegvesky@arrow.com>"
SECTION = "arrow-sockit"

PR = "r1"

inherit systemd

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PACKAGE_ARCH = "${MACHINE_ARCH}"
SRCREV = "${AUTOREV}"
PV = "1.0${PR}"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = "file://arrow-sockit-xfce-init.service \
          "

do_install() {
	install -d ${D}${base_libdir}/systemd/system
	install -m 0644 ${WORKDIR}/*.service ${D}${base_libdir}/systemd/system
}

ALLOW_EMPTY_${PN} = "1"

FILES_${PN} = "${base_libdir}/systemd/system/arrow-sockit-xfce-init.service \
		      "

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "arrow-sockit-xfce-init.service"
DISTRO_FEATURES = "systemd"
