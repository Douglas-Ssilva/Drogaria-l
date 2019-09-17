
    function verify(xhr, status, args, dlg, tbl) {
        if(args.validationFailed) { /*True quando o required dá problema, não preencher campos*/
            PF(dlg).jq.effect("shake", {times:5}, 100);
        }
        else {/*Caso preencha os campos...Substitui o oncomplete*/
            PF(dlg).hide();
            PF(tbl).clearFilters();
        }
    }
/*Comando PF serve pra chamarmos componentes do prime por meio do widgtVar*/