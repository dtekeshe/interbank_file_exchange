#echo executing 01_dmcs_schema.sql
mysql -h 172.16.161.223 -u DmcsApps CCCOWNER --password=AppsDmcs < /home/jboss/dmcs/sql/01_dmcs_schema.sql
#echo 02_dmcs_data.sql
mysql -h 172.16.161.223 -u DmcsApps CCCOWNER --password=AppsDmcs < /home/jboss/dmcs/sql/02_dmcs_data.sql
#echo 03_dmcs_constraint.sql
mysql -h 172.16.161.223 -u DmcsApps CCCOWNER --password=AppsDmcs < /home/jboss/dmcs/sql/03_dmcs_constraint.sql
#echo 04_dmcs_alter_cso_input_file_controls.sql
mysql -h 172.16.161.223 -u DmcsApps CCCOWNER --password=AppsDmcs < /home/jboss/dmcs/sql/04_dmcs_alter_cso_input_file_controls.sql
#echo 05_dmcs_update_csf_directories.sql
mysql -h 172.16.161.223 -u DmcsApps CCCOWNER --password=AppsDmcs < /home/jboss/dmcs/sql/05_dmcs_update_csf_directories.sql 
#echo 06_dmcs_fix_primary_keys.sql
mysql -h 172.16.161.223 -u DmcsApps CCCOWNER --password=AppsDmcs < /home/jboss/dmcs/sql/06_dmcs_fix_primary_keys.sql
#echo 07_dmcs_cso_transactions_view.sql
mysql -h 172.16.161.223 -u DmcsApps CCCOWNER --password=AppsDmcs < /home/jboss/dmcs/sql/07_dmcs_cso_transactions_view.sql
#echo 08_dmcs_csv_transactions_view.sql
mysql -h 172.16.161.223 -u DmcsApps CCCOWNER --password=AppsDmcs < /home/jboss/dmcs/sql/08_dmcs_csv_transactions_view.sql
#echo 09_dmcs_csf_txn_types_normalised_view.sql
mysql -h 172.16.161.223 -u DmcsApps CCCOWNER --password=AppsDmcs < /home/jboss/dmcs/sql/09_dmcs_csf_txn_types_normalised_view.sql
#echo 10_dmcs_csf_txn_types_collated_view.sql
mysql -h 172.16.161.223 -u DmcsApps CCCOWNER --password=AppsDmcs < /home/jboss/dmcs/sql/10_dmcs_csf_txn_types_collated_view.sql
#echo 11_dmcs_ccr00x_report_layout_view.sql
mysql -h 172.16.161.223 -u DmcsApps CCCOWNER --password=AppsDmcs < /home/jboss/dmcs/sql/11_dmcs_ccr00x_report_layout_view.sql
#echo 12_dmcs_csv_transactions_collated_view.sql
mysql -h 172.16.161.223 -u DmcsApps CCCOWNER --password=AppsDmcs < /home/jboss/dmcs/sql/12_dmcs_csv_transactions_collated_view.sql
#echo 13_dmcs_ccr00x_report_data_view.sql
mysql -h 172.16.161.223 -u DmcsApps CCCOWNER --password=AppsDmcs < /home/jboss/dmcs/sql/13_dmcs_ccr00x_report_data_view.sql
#echo 14_dmcs_csv_ccr00x_data_view.sql
mysql -h 172.16.161.223 -u DmcsApps CCCOWNER --password=AppsDmcs < /home/jboss/dmcs/sql/14_dmcs_csv_ccr00x_data_view.sql
#echo 15_dmcs_css_month_stats.sql
mysql -h 172.16.161.223 -u DmcsApps CCCOWNER --password=AppsDmcs < /home/jboss/dmcs/sql/15_dmcs_css_month_stats.sql
#echo 15_dmcs_css_stats_view.sql
mysql -h 172.16.161.223 -u DmcsApps CCCOWNER --password=AppsDmcs < /home/jboss/dmcs/sql/15_dmcs_css_stats_view.sql
#echo 16_dmcs_ccr015_view.sql
mysql -h 172.16.161.223 -u DmcsApps CCCOWNER --password=AppsDmcs < /home/jboss/dmcs/sql/16_dmcs_ccr015_view.sql 
#echo 17_dmcs_sequence_store.sql
mysql -h 172.16.161.223 -u DmcsApps CCCOWNER --password=AppsDmcs < /home/jboss/dmcs/sql/17_dmcs_sequence_store.sql
#echo done.
