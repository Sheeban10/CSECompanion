package com.example.csecompanionadminapp.model

data class StudentAttendance(
    var attendDdb : String? = null,
    var attendDdbLab: String? = null,
    var attendAdhoc: String? = null,
    var attendAdhocLab: String? = null,
    var attendBd: String? = null,
    var attendNsc: String? = null,
    var attendDwdm: String? = null,
    var attendProjLab: String? = null,
    var uid: String? = null,
    var name: String? = null,
    var rollNo : String? = null
)
