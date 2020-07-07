import React from 'react';

function Pif(props)
{
    console.log(props);
    return(
        <div className = "airmen">
            <p>AIRMAN ID: {props.id}</p>
            <p>LOC? {String(props.LOC)} </p>
            <p>LOR? {String(props.LOR)}</p> 
            <p>LOA? {String(props.LOA)}</p>
            <p> WAPS? {String(props.WAPS)}</p> 
           <p> Time: {props.last_review_date}</p>
    
        </div>
    )
}
export default Pif;