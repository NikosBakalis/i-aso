select patient.amka, patient.first_name, patient.last_name, admission_ticket.host_clinic, admission_ticket.patient_chamber, patient_file.doctor, patient_file.hospital, admission_ticket.admission_clinic, admission_ticket.stage 
from patient_file
inner join admission_ticket
on patient_file.file_id = admission_ticket.ticket_id
inner join patient
on patient_file.patient_amka = patient.amka
where patient_file.hospital = '0123456789'
and admission_ticket.admission_clinic = 'ΜΕΘ';

select amka, afm, first_name, last_name, gender, father_first_name, mother_first_name, birth_date from patient 
where amka like '%' 
and afm like '%'
and first_name like 'ΑΝΔΡΕΑΣ'
and last_name like '%' 
and gender like '%'
and (father_first_name like '%' or father_first_name is null);
and father_last_name like '%' 
and mother_first_name like '%' 
and mother_last_name like '%' 
and birth_date like '%';



