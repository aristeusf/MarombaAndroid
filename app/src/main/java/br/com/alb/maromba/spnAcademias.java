package br.com.alb.maromba;

/**
 * Created by Aristeu da Silva Filho on 13/09/2016.
 */
public class spnAcademias {

        private String id;
        private String Razao;

        public void setId(String Id)
        {
            this.id = Id;
        }

        public void setRazao(String razao)
        {
            this.Razao = razao;
        }

        public String getId()
        {
            return this.id;
        }

        public String getDescricao()
        {
            return this.Razao;
        }
}
