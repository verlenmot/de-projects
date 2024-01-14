variable "client_id" {
  default   = ""
  sensitive = true
}

variable "client_secret" {
  default   = ""
  sensitive = true
}

variable "tenant_id" {
  default   = ""
  sensitive = true
}

variable "subscription_id" {
  default   = ""
  sensitive = true
}

variable "api_key" {
  default   = ""
  sensitive = true
}

variable "ip_exceptions" {
  default   = ""
  sensitive = true
}

variable "alert_email" {
  default   = ""
  sensitive = true
}

variable "project_name" {
  default = "weather"
}

variable "scala_path" {
  default = "../scala"
}